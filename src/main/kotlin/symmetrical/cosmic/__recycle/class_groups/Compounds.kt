package symmetrical.cosmic.__recycle.class_groups

import symmetrical.cosmic.__recycle.ClassGroup
import symmetrical.cosmic.__recycle.EntityId
import symmetrical.cosmic.__transpectors.printable_characters.Base52
import symmetrical.cosmic._physics._subatomic.forces.strong_force.Strong
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics.atomic.atoms.elements.Helium
import symmetrical.cosmic._physics.atomic.atoms.elements.Hydrogen
import symmetrical.cosmic._physics.atomic.bonds.alloys.Alloy
import symmetrical.cosmic._physics.atomic.bonds.covalent.Diatomic
import symmetrical.cosmic._physics.atomic.bonds.covalent.Molecular
import symmetrical.cosmic._physics.atomic.bonds.mixtures.Mixture
import symmetrical.cosmic._physics.atomic.bonds.mixtures.Solution
import symmetrical.cosmic._physics.atomic.matter.Material
import symmetrical.cosmic._physics.atomic.substance.ions.Compound
import symmetrical.cosmic._physics.atomic.substance.molecules.Molecule

class Compounds : ClassGroup {
    constructor() {
        add(EntityId(Base52.classId(), Alloy::class))
        add(EntityId(Base52.classId(), Atom::class))
        add(EntityId(Base52.classId(), Compound::class))
        add(EntityId(Base52.classId(), Diatomic::class))
        add(EntityId(Base52.classId(), Helium::class))
        add(EntityId(Base52.classId(), Hydrogen::class))
        add(EntityId(Base52.classId(), Material::class))
        add(EntityId(Base52.classId(), Mixture::class))
        add(EntityId(Base52.classId(), Molecular::class))
        add(EntityId(Base52.classId(), Molecule::class))
        add(EntityId(Base52.classId(), Material::class))
        add(EntityId(Base52.classId(), Solution::class))

    }
}