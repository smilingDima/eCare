package ecare.local.service.impl;

import ecare.local.service.PaginationAndSortingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class PaginationAndSortingServiceImpl implements PaginationAndSortingService {
    @Override
    public Pageable getPageble(
            Integer pageNumber,
            Integer itemsPerPage,
            String[] sortBy,
            Boolean[] sortDescending,
            String defaultSortBy
    ) {
        // Setting default values if not set
        int pageNumberInt = getDefaultValueIfNull(pageNumber , 1);
        int itemsPerPageInt = getDefaultValueIfNull(itemsPerPage ,10);
        String[] sortByValidated = getDefaultValueIfNullOrEmpty(sortBy, () -> new String[]{defaultSortBy});
        Boolean[] sortDescendingValidated = getDefaultValueIfNullOrEmpty(sortDescending, () -> new Boolean[]{false});

        return PageRequest.of(
                pageNumberInt - 1,  // At PageRequest page number starts from 0
                itemsPerPageInt,
                parseSort(sortByValidated, sortDescendingValidated)
        );
    }

    /**
     * Generate sort object from sortBy and sortDescending arrays.
     * Length of {@code sortBy} and {@code sortDescending} should be the same and not null or empty.
     * @param sortBy array of filed names. Shouldn't be null or empty.
     * @param sortDescending array of type of sorting for appropriate {@code sortBy} field.
     *                       Array length should be the same as {@code sortBy}.
     * @return Sort object
     */
    private Sort parseSort(String[] sortBy, Boolean[] sortDescending) {
        Assert.isTrue(sortBy.length == sortDescending.length,
                "sortBy and sortDescending should be the same size");
        Assert.isTrue(sortBy.length > 0, "sotBy shouldn't be empty");

        Sort sort = parseSortElem(sortBy[0], sortDescending[0]);
        for (int i = 1; i < sortBy.length; i++) {
            sort = sort.and(parseSortElem(sortBy[i], sortDescending[i]));
        }
        return sort;
    }

    /**
     * Returns Sort object for one field.
     * @param fieldName Field name
     * @param desc Descending if true, ascending if false.
     * @return Sort object
     */
    private Sort parseSortElem(String fieldName, Boolean desc) {
        return ((desc) ? Sort.by(fieldName).descending() : Sort.by(fieldName));
    }

    /**
     * Converting from Integer to int. If {@code i} is null - returns {@code defaultValue}
     */
    private int getDefaultValueIfNull(Integer i, int defaultValue) {
        return ((i == null) ? defaultValue : i);
    }

    /**
     * Replace {@code array} with {@code defaultArrayFactory} if it is null or empty
     * @param array Array of any type(String, boolean)
     * @param defaultArrayFactory Supplier with defaultArray which is the same type as {@code array}.
     *
     * @return {@code array} or {@code defaultArray}
     *
     * Example:
     * {@code String[] sortByValidated = getDefaultValueIfNullOrEmpty(sortBy, () -> new String[]{defaultSortBy}); }         *
     */
    private <T> T[] getDefaultValueIfNullOrEmpty(T[] array, Supplier<T[]> defaultArrayFactory) {
        // https://stackoverflow.com/a/46444056/2879364
        if (array == null) {
            return defaultArrayFactory.get();
        }
        if (array.length == 0) {
            return defaultArrayFactory.get();
        }
        return array;
    }

}
