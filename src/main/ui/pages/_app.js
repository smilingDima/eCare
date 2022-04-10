import '../styles/globals.css'
import '../styles/tailwind.css'

import { SWRConfig, useSWRConfig} from 'swr'

function MyApp({ Component, pageProps }) {
    const { mutate } = useSWRConfig();
    return(
        <SWRConfig value={{
            // refreshInterval: 5000,
            fetcher: (resource, init) => fetch(resource, init).then(res => res.json())
        }}>
            <Component {...pageProps} />
        </SWRConfig>
  )
}

export default MyApp
