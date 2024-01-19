package symmetrical.cosmic.physics.subatomic.spacial
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

import kotlin.reflect.KClass
/*
https://en.wikipedia.org/wiki/Particle_beam
 */
interface IBeam {
    fun add             (obj:Any?)                      : Any?
    fun addAll          (beam: IBeam)                   : IBeam
    fun clear           ()                              : IBeam
    fun compress        ()                              : IBeam
    fun contract        (newSize:Int)                   : IBeam
    fun expand          (newSize:Int)                   : IBeam
    fun get             (pos:Int)                       : Any?
    fun getClassId      ()                              : String
    fun getCore         ()                              : Array<Any?>
    fun find            (item:Any)                      : Int
    fun findByType      (classType: KClass<*>)             : Int
    fun isEmpty         ()                              : Boolean
    fun isNotEmpty      ()                              : Boolean
    fun popLeft         ()                              : Any?
    fun remove          (item:Any)                      : Any
    fun removeAt        (pos:Int)                       : Any?
    fun set             (pos:Int, any: Any?)            : Any?
    fun shrink          ()                              : IBeam
    fun size            ()                              : Int
}