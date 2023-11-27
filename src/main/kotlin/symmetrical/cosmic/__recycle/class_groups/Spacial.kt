package symmetrical.cosmic.__recycle.class_groups

import symmetrical.cosmic.__recycle.ClassGroup
import symmetrical.cosmic.__recycle.EntityId
import symmetrical.cosmic.__transpectors.printable_characters.Base52
import symmetrical.cosmic._physics._subatomic.spacial.Beam
import symmetrical.cosmic._physics._subatomic.spacial.Composition
import symmetrical.cosmic._physics._subatomic.spacial.ParticleBeam

class Spacial : ClassGroup {
    constructor() {
        add(EntityId(Base52.classId(), Beam::class))
        add(EntityId(Base52.classId(), Composition::class))
        add(EntityId(Base52.classId(), ParticleBeam::class))
    }
}