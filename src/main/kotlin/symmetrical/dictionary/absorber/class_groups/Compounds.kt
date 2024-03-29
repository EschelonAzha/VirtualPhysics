package symmetrical.dictionary.absorber.class_groups
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

import symmetrical.dictionary.absorber.ClassGroup
import symmetrical.dictionary.absorber.EntityId
import symmetrical.transpectors.printable_characters.Base52
import symmetrical.physics.atomic.atoms.Atom
import symmetrical.physics.atomic.atoms.elements.Helium
import symmetrical.physics.atomic.atoms.elements.Hydrogen
import symmetrical.physics.atomic.bonds.alloys.Alloy
import symmetrical.physics.atomic.bonds.covalent.Diatomic
import symmetrical.physics.atomic.bonds.covalent.Molecular
import symmetrical.physics.atomic.bonds.mixtures.Mixture
import symmetrical.physics.atomic.bonds.mixtures.Solution
import symmetrical.physics.atomic.substance.Substance
import symmetrical.physics.atomic.substance.ions.Compound
import symmetrical.physics.atomic.substance.molecules.Molecule

open class Compounds : ClassGroup() {
    init {
        add(EntityId().with(Base52.classId(), Alloy::class))
        add(EntityId().with(Base52.classId(), Atom::class))
        add(EntityId().with(Base52.classId(), Compound::class))
        add(EntityId().with(Base52.classId(), Diatomic::class))
        add(EntityId().with(Base52.classId(), Helium::class))
        add(EntityId().with(Base52.classId(), Hydrogen::class))
        add(EntityId().with(Base52.classId(), Substance::class))
        add(EntityId().with(Base52.classId(), Mixture::class))
        add(EntityId().with(Base52.classId(), Molecular::class))
        add(EntityId().with(Base52.classId(), Molecule::class))
        add(EntityId().with(Base52.classId(), Solution::class))
    }
}