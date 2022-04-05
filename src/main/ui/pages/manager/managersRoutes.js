import Head from "next/head";
import Link from "next/link";

export default function ManagersRoutes() {
    return (
        <>
            <Head>
                <title>Manager Routes</title>
            </Head>
            <Link href="/manager">
                <a>Main page</a>
            </Link>
            <br />
            <Link href="/manager/tariff">
                <a>Tariff</a>
            </Link>
        </>
    )
}