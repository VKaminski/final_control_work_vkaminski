package com.gmail.kaminski.viktar.shop.controller;

import com.gmail.kaminski.viktar.shop.controller.validator.DateValidator;
import com.gmail.kaminski.viktar.shop.service.DiscountService;
import com.gmail.kaminski.viktar.shop.service.model.DiscountDTO;
import com.gmail.kaminski.viktar.shop.service.model.NewDiscountDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RESTController {
    private DiscountService discountService;
    private DateValidator dateValidator;

    public RESTController(DiscountService discountService, DateValidator dateValidator) {
        this.discountService = discountService;
        this.dateValidator = dateValidator;
    }

    @PostMapping ("/private/users/{id}/discounts")
    public ResponseEntity<String> addDiscount(
            @PathVariable("id") Long userId,
            @Valid @RequestBody NewDiscountDTO discountDTO
    ){
        String validateMessage = dateValidator.valid(discountDTO.getExpirationDate(), 1l);
        if(validateMessage != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            discountService.add(userId, discountDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @GetMapping("/public/users/{id}/discounts")
    public ResponseEntity<List<DiscountDTO>> showAllDiscountForUser(
            @PathVariable("id") Long id
    ){
        List<DiscountDTO> discountDTOs = discountService.findAllDiscountForUser(id);
        return new ResponseEntity<>(discountDTOs, HttpStatus.OK);
    }

    @DeleteMapping("/private/users/*/discounts/{discountId}")
    public ResponseEntity<String> deleteBusinessCardInUser(
            @PathVariable("discountId") Long discountId
    ){
        discountService.delete(discountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<String> allErrorHandler(MethodArgumentNotValidException e) {
        return e.getBindingResult()
                .getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
    }
}
