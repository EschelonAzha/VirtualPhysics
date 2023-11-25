package symmetrical.cosmic.__recycle.class_groups

import symmetrical.cosmic.__recycle.ClassGroup
import symmetrical.cosmic.__recycle.EntityId
import symmetrical.cosmic.__transpectors.printable_characters.Base52
import symmetrical.cosmic._physics._subatomic.matter.hadrons.Hadron
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Baryon
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Neutron
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Neutrons
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Nucleons
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Protons

class Hadrons : ClassGroup {
    constructor() {
        add(EntityId(Base52.classId(), Baryon::class))
        add(EntityId(Base52.classId(), Hadron::class))
        add(EntityId(Base52.classId(), Neutron::class))
        add(EntityId(Base52.classId(), Neutrons::class))
        add(EntityId(Base52.classId(), Nucleons::class))
        add(EntityId(Base52.classId(), Proton::class))
        add(EntityId(Base52.classId(), Protons::class))
    }
}