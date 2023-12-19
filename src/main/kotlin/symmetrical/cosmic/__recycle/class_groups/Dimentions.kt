package symmetrical.cosmic.__recycle.class_groups

import symmetrical.cosmic.__recycle.ClassGroup
import symmetrical.cosmic.__recycle.EntityId
import symmetrical.cosmic.__transpectors.printable_characters.Base52
import symmetrical.cosmic._physics._dimensions.Charge
import symmetrical.cosmic._physics._dimensions.Mass
import symmetrical.cosmic._physics._dimensions.Temperature
import symmetrical.cosmic._physics._dimensions.Time

class Dimentions : ClassGroup {
    constructor() {
        add(EntityId(Base52.classId(), Time::class))
        add(EntityId(Base52.classId(), Charge::class))
        add(EntityId(Base52.classId(), Mass::class))
        add(EntityId(Base52.classId(), Temperature::class))

    }
}