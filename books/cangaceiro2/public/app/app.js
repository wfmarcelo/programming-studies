import { handleStatus, log } from "./utils/promise-helpers.js";
import './utils/array-helpers.js'
import { notasService } from "./nota/service.js";



document
    .querySelector('#myButton')
    .onclick = () =>

        notasService
            .sumItems('2143')
            .then(log)
            .catch(log);