package symmetrical.cosmic.absorber.class_groups

import symmetrical.cosmic.absorber.ClassGroup
import symmetrical.cosmic.absorber.EntityId
import symmetrical.cosmic.transpectors.printable_characters.Base52

import symmetrical.cosmic.physics.dimensions.*

class Dimentions : ClassGroup {
    constructor() {

        add(EntityId(Base52.classId(), Charge::class))
        add(EntityId(Base52.classId(), Mass::class))
        add(EntityId(Base52.classId(), Space::class))
        add(EntityId(Base52.classId(), Temperature::class))
        add(EntityId(Base52.classId(), Time::class))

    }
}