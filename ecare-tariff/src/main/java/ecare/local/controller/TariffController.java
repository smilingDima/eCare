package ecare.local.controller;

import ecare.local.dto.TariffDto;
import ecare.local.service.PaginationAndSortingService;
import ecare.local.service.TariffService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class TariffController {
    private final TariffService tariffService;
    private final PaginationAndSortingService paginationAndSortingService;
    private static final Logger logger = LogManager.getLogger(TariffController.class);

    @GetMapping("/tariff")
    public Iterable<TariffDto> getAllTariffs(
            @RequestParam(value = "pageNumber", required=false) Integer pageNumber,
            @RequestParam(value = "itemsPerPage", required=false) Integer itemsPerPage,
            @RequestParam(value = "sortBy", required=false) String[] sortBy,
            @RequestParam(value = "sortDescending", required=false) Boolean[] sortDescending) {
        Pageable pageable = paginationAndSortingService.getPageble(pageNumber, itemsPerPage, sortBy, sortDescending, "name");
        return tariffService.findAll(pageable);
    }

    @GetMapping("/tariff/{id}")
    public TariffDto getTariff(@PathVariable("id") long id) {
        logger.info("Request /tariff/{id} with id");
        return tariffService.findById(id);
    }
    @DeleteMapping("/tariff/{id}")
    public String deleteTariff(@PathVariable("id") long id) {
        tariffService.deleteById(id);
        return "redirect:/tariff";
    }
}
