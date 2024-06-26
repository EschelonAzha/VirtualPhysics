package symmetrical.dictionary.absorber.class_groups

import symmetrical.dictionary.absorber.ClassGroup
import symmetrical.dictionary.absorber.EntityId
import symmetrical.dictionary.quasiparticles.GalaxyId
import symmetrical.dictionary.quasiparticles.LoginId
import symmetrical.dictionary.quasiparticles.RemoteId
import symmetrical.transpectors.printable_characters.Base52

class QuasiParticles : ClassGroup() {
    init {
        add(EntityId().with(Base52.classId(), GalaxyId::class))
        add(EntityId().with(Base52.classId(), LoginId::class))
        add(EntityId().with(Base52.classId(), RemoteId::class))
    }
}