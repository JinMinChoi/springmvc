package practice.springmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

/**
 * It is about Meta-annotaion
 * XD
 */

@Target(value = ElementType.ANNOTATION_TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.GET, value = "/meta")
@Documented
public @interface GetMetaMapping {
}
