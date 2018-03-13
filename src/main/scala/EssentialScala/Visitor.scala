package EssentialScala

import java.util.Date

sealed trait Visitor {
  def id: String
  def createdAt: Date
  // How long has this visitor been around?
  def age: Long = new Date().getTime - createdAt.getTime
  def older(v1: Visitor, v2: Visitor): Boolean =
    v1.createdAt.before(v2.createdAt)
}

case class Anonymous(id: String, createdAt: Date = new Date())           extends Visitor
case class User(id: String, email: String, createdAt: Date = new Date()) extends Visitor
