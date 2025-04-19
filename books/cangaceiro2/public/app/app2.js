import { inspectMethod, logExecutionTime } from "./models/decorators.js";
import { Person } from "./models/person.js";
import { decorate } from "./utils/decorate.js";


decorate(Person, {
    speak: [logExecutionTime, inspectMethod({excludeReturn: true})],
    getFullName: [logExecutionTime]
});

const person = new Person('Marcelo', 'Wollmann Figueiró');
person.getFullName();
person.speak('Cangaceiro JavaScript');