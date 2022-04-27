import useSWR, {mutate} from 'swr';
import Cookies from 'js-cookie';

export function apiGetTariffs() {
  const { data, error } = useSWR(`/api/tariffs`)
  return {
    tariffs: data,
    isLoading: !error && !data,
    isError: error
  }
}

export function apiGetTariff(id) {
  const { data, error } = useSWR(`/api/tariffs/${id}`)
  return {
    tariff: data,
    isLoading: !error && !data,
    isError: error
  }
}

export async function apiPatchTariff(id, values) {
  // const csrfToken = document.cookie.replace(/(?:(?:^|.*;\s*)XSRF-TOKEN\s*\=\s*([^;]*).*$)|^.*$/, '$1');
  const response = await fetch(`/api/tariffs/${id}`, {
    method: 'PATCH',
    body: JSON.stringify(values),
    headers: {
      'Content-Type': 'application/json',
      // 'X-XSRF-TOKEN': csrfToken, // https://www.baeldung.com/spring-security-csrf
      'X-XSRF-TOKEN': Cookies.get('XSRF-TOKEN')
    },
  })
  await mutate(`/api/tariffs/${id}`)
  return response.status
}

export default {apiGetTariffs, apiGetTariff, apiPatchTariff}
