package applications

import applications.tests.dictionary.atoms.*
import applications.tests.dictionary.composites.AddressRow
import symmetrical.dictionary.absorber.ClassGroup
import symmetrical.dictionary.absorber.EntityId
import symmetrical.transpectors.printable_characters.Base52


class TestPhysicsEmitters : ClassGroup() {
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

    init {
        add(EntityId().with(Base52.classId(), Address::class))  // <-- Add to list
        add(EntityId().with(Base52.classId(), AddressRow::class))
        add(EntityId().with(Base52.classId(), City::class))
        add(EntityId().with(Base52.classId(), Name::class))
        add(EntityId().with(Base52.classId(), Resistor::class))
        add(EntityId().with(Base52.classId(), State::class))
    }
}