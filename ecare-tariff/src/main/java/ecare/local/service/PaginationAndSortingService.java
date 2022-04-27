package ecare.local.service;

import org.springframework.data.domain.Pageable;

public interface PaginationAndSortingService {
    /**
     * Parsing received options and return Pageble object
     * that can be used at PagingAndSortingRepository DTO
     *
     * @param pageNumber     Page number starts from 1, default 1 (if null)
     * @param itemsPerPage   Items of elements on a page, default 10
     * @param sortBy         Names of fields in witch order list should be ordered
     * @param sortDescending Each element of array matches {@code sortBy} element.
     *                       Length of {@code sortBy} and {@code sortDescending} should be the same.
     * @param defaultSortBy  Field name that used if {@code sortBy} is null or empty
     *
     * @return Pageable object for {@code findAll(Pageble)} of PagingAndSortingRepository interfaces
     */
    public Pageable getPageble(
            Integer pageNumber,
            Integer itemsPerPage,
            String[] sortBy,
            Boolean[] sortDescending,
            String defaultSortBy
    );
}
