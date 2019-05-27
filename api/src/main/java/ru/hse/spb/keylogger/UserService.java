package ru.hse.spb.keylogger;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Nonnull;


@RequestMapping("/api")
public interface UserService {
    @RequestMapping(method = RequestMethod.GET,
            value = "/register",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    String register(@Nonnull @RequestParam("login") String login,
                    @Nonnull @RequestParam("password") String password);
}
