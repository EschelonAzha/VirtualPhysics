package symmetrical.cosmic.absorber.class_groups

import symmetrical.cosmic.absorber.ClassGroup
import symmetrical.cosmic.absorber.EntityId
import symmetrical.cosmic.transpectors.printable_characters.Base52
import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.atomic.atoms.elements.Helium
import symmetrical.cosmic.physics.atomic.atoms.elements.Hydrogen
import symmetrical.cosmic.physics.atomic.bonds.alloys.Alloy
import symmetrical.cosmic.physics.atomic.bonds.covalent.Diatomic
import symmetrical.cosmic.physics.atomic.bonds.covalent.Molecular
import symmetrical.cosmic.physics.atomic.bonds.mixtures.Mixture
import symmetrical.cosmic.physics.atomic.bonds.mixtures.Solution
import symmetrical.cosmic.physics.atomic.matter.Material
import symmetrical.cosmic.physics.atomic.substance.ions.Compound
import symmetrical.cosmic.physics.atomic.substance.molecules.Molecule

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
        add(EntityId(Base52.classId(), Solution::class))

    }
}