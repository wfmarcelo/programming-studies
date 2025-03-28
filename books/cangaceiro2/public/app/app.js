import { notasService } from "./nota/service.js";
import './utils/array-helpers.js';
import { debounceTime, partialize, pipe, takeUntil } from "./utils/operators.js";
import { log, retry, timeoutPromise } from "./utils/promise-helpers.js";

const operations = pipe(
    partialize(takeUntil, 3),
    partialize(debounceTime, 500)
);

const action = operations(() =>
    retry(3, 3000, () => timeoutPromise(200, notasService.sumItems('2143')))
        .then(log)
        .catch(log));

document
    .querySelector('#myButton')
    .onclick = action;

