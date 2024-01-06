package symmetrical.cosmic.absorber.class_groups

import symmetrical.cosmic.absorber.ClassGroup
import symmetrical.cosmic.absorber.EntityId
import symmetrical.cosmic.transpectors.printable_characters.Base52
import symmetrical.cosmic.physics.atomic.substance.ions.Anion
import symmetrical.cosmic.physics.atomic.substance.ions.Cation
import symmetrical.cosmic.physics.atomic.substance.ions.Ion

class Ions : ClassGroup {
    constructor() {
        add(EntityId(Base52.classId(), Anion::class))
        add(EntityId(Base52.classId(), Cation::class))
        add(EntityId(Base52.classId(), Ion::class))

    }
}