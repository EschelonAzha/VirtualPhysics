package applications

import applications.tests.dictionary.Resistor
import symmetrical.cosmic.absorber.ClassGroup
import symmetrical.cosmic.absorber.EntityId
import symmetrical.cosmic.transpectors.printable_characters.Base52


class TestPhysicsEmitters : ClassGroup {
    // Custom user Particles (such as Resistor)
    // should be added to the emitters list if you want them to be able
    // to emit() themselves (serialize), and then be
    // able to re-materialize themselves via absorption (deserialize)
    // and pass this data from machine to machine without needing intermediate
    // steps such as JSON, XML or Protocol Buffers

    // Very complex user defined structures can be constructed,
    // emitted and then re-materialized on a different machine
    // using no extra third party libraries or tools.
    // one line of code on the first machine:  emission = object.emit()
    // one line of code on the second macine:  clone = Absorber.materialize(emission)
    // that is all that is needed!

    constructor() {
        add(EntityId(Base52.classId(), Resistor::class))  // <-- Add to list

    }
}