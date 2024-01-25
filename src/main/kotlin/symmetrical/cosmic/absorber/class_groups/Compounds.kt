package symmetrical.cosmic.absorber.class_groups
/*
 * This file is part of Virtual Physics.
 *
 * Copyright (C) [2024] Stephen R. DeSofi AKA Eschelon Azha
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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

open class Compounds : ClassGroup() {
    init {
        add(EntityId().with(Base52.classId(), Alloy::class))
        add(EntityId().with(Base52.classId(), Atom::class))
        add(EntityId().with(Base52.classId(), Compound::class))
        add(EntityId().with(Base52.classId(), Diatomic::class))
        add(EntityId().with(Base52.classId(), Helium::class))
        add(EntityId().with(Base52.classId(), Hydrogen::class))
        add(EntityId().with(Base52.classId(), Material::class))
        add(EntityId().with(Base52.classId(), Mixture::class))
        add(EntityId().with(Base52.classId(), Molecular::class))
        add(EntityId().with(Base52.classId(), Molecule::class))
        add(EntityId().with(Base52.classId(), Solution::class))
    }
}