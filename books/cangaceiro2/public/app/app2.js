import { Person } from "./models/person.js";

const person = new Person('Marcelo', 'Wollmann Figueiró');
person.speak('Cangaceiro JavaScript');
person.getFullName();