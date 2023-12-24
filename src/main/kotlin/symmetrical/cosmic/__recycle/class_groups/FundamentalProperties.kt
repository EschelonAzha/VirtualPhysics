package symmetrical.cosmic.__recycle.class_groups

import symmetrical.cosmic.__recycle.ClassGroup
import symmetrical.cosmic.__recycle.EntityId
import symmetrical.cosmic.__transpectors.printable_characters.Base52
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.Fundamentals
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.AngularMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.luminescent.QuantumField

class FundamentalProperties : ClassGroup {
    constructor() {
        add(EntityId(Base52.classId(), AngularMomentum::class))
        add(EntityId(Base52.classId(), Fundamentals::class))
        add(EntityId(Base52.classId(), Particle::class))
        add(EntityId(Base52.classId(), Wavelength::class))
        add(EntityId(Base52.classId(), QuantumField::class))
        add(EntityId(Base52.classId(), Spin::class))

    }
}