import axios from "axios";

/** Handles the base url for fetching data.
 *  @param baseURL
 *  @return instance
 */

const instance = axios.create({
  baseURL: "http://localhost:8080"
});

export default instance;
