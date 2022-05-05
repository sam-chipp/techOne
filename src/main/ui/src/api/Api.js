import axios from "axios";
import { useEffect, useState } from "react";

export function useGetWords(props) {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState();

  useEffect(() => {
    if (props !== "") {
      setLoading(true);

      (async () => {
        await axios
          .post("http://localhost:8080/api/convert", {
            number: props
          }, {
            headers: {
              Accept: 'application/json',
              'Content-Type': 'application/json',
            }
          })
          .then((res) => {
            setData(res.data);
            setLoading(false);
          })
          .catch((err) => {
            console.log(err);
            setError(err);
            setLoading(false);
          });
      })();
    }
  }, [props]);

  return {
    data,
    loading,
    error
  };
}
