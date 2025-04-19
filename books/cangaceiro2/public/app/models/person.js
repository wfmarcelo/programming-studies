export class Person {
    constructor(name, surname) {
        this.name = name;
        this.surname = surname;
    }

    // @logExecutionTime
    speak(phrase) {
        return `${this.name} is speaking... ${phrase}`;
    }
    
    // @logExecutionTime
    getFullName() {
        return `${this.name} ${this.surname}`;
    }
}