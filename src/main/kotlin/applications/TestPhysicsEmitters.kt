package applications

import applications.tests.dictionary.Resistor
import symmetrical.cosmic.absorber.ClassGroup
import symmetrical.cosmic.absorber.EntityId
import symmetrical.cosmic.transpectors.printable_characters.Base52


class TestPhysicsEmitters : ClassGroup {
    constructor() {
        add(EntityId(Base52.classId(), Resistor::class))

    }
}