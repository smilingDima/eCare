package ecareserver.local.ecare.controller;

import ecareserver.local.ecare.feignClient.TariffClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class TariffController {
    final TariffClient tariffClient;

    @RequestMapping(value = "/get-tariff", produces = "application/json")
    @ResponseBody
    public String getTariff() {
        return tariffClient.getTariffProxy();
    }

    @RequestMapping(value = "/get-tariff/{id}", produces = "application/json")
    @ResponseBody
    public String getTariff(@PathVariable("id") long id) {
        return tariffClient.getTariffProxy(id);
    }
}
