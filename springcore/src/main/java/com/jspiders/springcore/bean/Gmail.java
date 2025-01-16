package com.jspiders.springcore.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component(value = "gmail")
//@Primary
public class Gmail implements Messanger {

}
