import { useEffect } from "react";
import axios from "axios"

function Callback() {
    const searchParams = new URLSearchParams(document.location.search)
    let code;
    useEffect(() => {
        code = searchParams.get('code');
        axios.post(`https://localhost:7070/link?code=${code}`)
    }, [])  

  return <div>You will be redirected to your page! {code}</div>;
}

export default Callback;
