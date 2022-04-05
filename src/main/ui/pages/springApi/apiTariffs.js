import useSWR from 'swr';
import {fetcher} from "./fetcher";

export function apiTariffs() {
  const { data, error } = useSWR(`/api/tariffs`, fetcher)
  return {
    tariffs: data,
    isLoading: !error && !data,
    isError: error
  }
}

export function apiTariff(id) {
  const { data, error } = useSWR(`/api/tariffs/${id}`, fetcher)
  return {
    tariff: data,
    isLoading: !error && !data,
    isError: error
  }
}

export default {apiTariffs, apiTariff}
