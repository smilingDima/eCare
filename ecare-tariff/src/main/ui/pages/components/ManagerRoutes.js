import Link from "next/link";

const ManagerRoutersLinkItem = (props) => {
    return (
        <Link href={props.href}>
            <a className="bg-sky-400 rounded-lg p-4 hover:bg-sky-300">
                {props.content}
            </a>
        </Link>
    )
}

export default function ManagerRoutes() {
    return (
        <div className="flex justify-start space-x-4 items-center h-24 text-white">
            <ManagerRoutersLinkItem href="/manager"             content="Main page"/>
            <ManagerRoutersLinkItem href="/manager/tariffs"     content="Tariffs"/>
        </div>
    )
}
