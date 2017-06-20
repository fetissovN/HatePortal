package com.nick.hateportal.validation;

import com.nick.hateportal.entity.Post;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PostFormValidator extends ValidatorSample implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Post.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Post post = (Post) o;

        validNotBlank(errors,"target", "post.target.empty", "Target must not be empty.");

        validNotBlank(errors, "title", "post.title.empty", "Title must not be empty.");
        valid(errors,post.getTitle(),"title", "post.title.tooShort", "Title should be more than 10 characters.",10);

        validNotBlank(errors, "post", "post.empty", "Post must not be empty.");
        valid(errors,post.getPost(),"post", "post.post.tooShort", "Post should be more than 30 characters.",30);
    }
}
