package com.example.ProductApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT,reason = "Product Not Added")
public class ProductNotAddedException extends Exception{
}
