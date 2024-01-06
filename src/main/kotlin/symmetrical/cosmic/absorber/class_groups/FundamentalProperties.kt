package symmetrical.cosmic.absorber.class_groups

import symmetrical.cosmic.absorber.ClassGroup
import symmetrical.cosmic.absorber.EntityId
import symmetrical.cosmic.physics.subatomic.balanced.Particle
import symmetrical.cosmic.transpectors.printable_characters.Base52
import symmetrical.cosmic.physics.subatomic.balanced.fundamentals.angularMomentum.AngularMomentum
import symmetrical.cosmic.physics.subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic.physics.subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic.physics.subatomic.luminescent.QuasiParticle

class FundamentalProperties : ClassGroup {
    constructor() {
        add(EntityId(Base52.classId(), AngularMomentum::class))
        add(EntityId(Base52.classId(), Particle::class))
        add(EntityId(Base52.classId(), QuasiParticle::class))
        add(EntityId(Base52.classId(), Spin::class))
        add(EntityId(Base52.classId(), Wavelength::class))
    }
}