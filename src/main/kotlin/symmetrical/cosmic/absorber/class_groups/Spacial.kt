package symmetrical.cosmic.absorber.class_groups

import symmetrical.cosmic.absorber.ClassGroup
import symmetrical.cosmic.absorber.EntityId
import symmetrical.cosmic.transpectors.printable_characters.Base52
import symmetrical.cosmic.physics.subatomic.spacial.Beam
import symmetrical.cosmic.physics.subatomic.spacial.Composition
import symmetrical.cosmic.physics.subatomic.spacial.ParticleBeam

class Spacial : ClassGroup {
    constructor() {
        add(EntityId(Base52.classId(), Beam::class))
        add(EntityId(Base52.classId(), Composition::class))
        add(EntityId(Base52.classId(), ParticleBeam::class))
    }
}