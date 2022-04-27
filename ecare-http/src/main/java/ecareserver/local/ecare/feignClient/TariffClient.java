package ecareserver.local.ecare.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("ecare-tariff")
@Service
public interface TariffClient {
    @RequestMapping(value = "/tariff")
    public String getTariffProxy();

    @RequestMapping(value = "/tariff/{id}")
    public String getTariffProxy(@PathVariable("id") long id);
}
