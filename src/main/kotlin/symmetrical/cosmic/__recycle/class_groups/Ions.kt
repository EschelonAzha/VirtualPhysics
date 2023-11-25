package symmetrical.cosmic.__recycle.class_groups

import symmetrical.cosmic.__recycle.ClassGroup
import symmetrical.cosmic.__recycle.EntityId
import symmetrical.cosmic.__transpectors.printable_characters.Base52
import symmetrical.cosmic._physics.atomic.substance.ions.Anion
import symmetrical.cosmic._physics.atomic.substance.ions.Cation
import symmetrical.cosmic._physics.atomic.substance.ions.Ion

class Ions : ClassGroup {
    constructor() {
        add(EntityId(Base52.classId(), Anion::class))
        add(EntityId(Base52.classId(), Cation::class))
        add(EntityId(Base52.classId(), Ion::class))

    }
}