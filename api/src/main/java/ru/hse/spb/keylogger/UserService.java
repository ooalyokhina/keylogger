package ru.hse.spb.keylogger;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.hse.spb.keylogger.dto.ResponseDto;

import javax.annotation.Nonnull;


@RequestMapping("/user")
public interface UserService {
    @RequestMapping(method = RequestMethod.POST,
            value = "/register",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseDto register(@Nonnull @RequestParam("login") String login,
                         @Nonnull @RequestParam("password") String password);
}
