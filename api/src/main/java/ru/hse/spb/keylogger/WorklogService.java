package ru.hse.spb.keylogger;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.hse.spb.keylogger.dto.DiffDto;
import ru.hse.spb.keylogger.dto.ResponseDto;

import javax.annotation.Nonnull;
import java.util.List;

@RequestMapping("/worklog")
public interface WorklogService {
    @RequestMapping(method = RequestMethod.POST,
            value = "/",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseDto register(@RequestBody DiffDto diff,
                         @Nonnull @RequestParam("token") String token);
}
