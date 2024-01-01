package applications

import applications.tests.dictionary.City
import symmetrical.cosmic.__recycle.ClassGroup
import symmetrical.cosmic.__recycle.EntityId
import symmetrical.cosmic.__transpectors.printable_characters.Base52


class TestPhysicsEmitters : ClassGroup {
    constructor() {
        add(EntityId(Base52.classId(), City::class))

    }
}