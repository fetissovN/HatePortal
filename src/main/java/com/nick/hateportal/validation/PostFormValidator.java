package com.nick.hateportal.validation;



import com.nick.hateportal.DTO.UserLoginDTO;
import com.nick.hateportal.entity.Post;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PostFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Post.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Post post = (Post) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "target", "post.target.empty", "Target must not be empty.");


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "post.title.empty", "Title must not be empty.");
        String titleStr = post.getTitle();
        if (titleStr.length() < 10){
            errors.rejectValue("title", "post.title.tooShort", "Title should be more than 10 characters.");
        }
        String postStr = post.getPost();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "post", "post.empty", "Post must not be empty.");
        if (postStr.length() < 30){
            errors.rejectValue("post", "post.post.tooShort", "Post should be more than 30 characters.");
        }

    }
}
