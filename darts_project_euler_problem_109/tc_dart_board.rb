require_relative "dart_board"
require "minitest/autorun"

class TestDartBoard < Minitest::Test

  def setup
    @board = DartBoard.new
  end

  def test_doubles
    assert_equal(false, @board.double?(1))
    assert_equal(true, @board.double?(2))
    assert_equal(false, @board.double?(3))
    assert_equal(true, @board.double?(4))
  end

  def test_amount
    assert_equal(1, @board.amount(1))
    assert_equal(2, @board.amount(2))
    assert_equal(3, @board.amount(12))
    assert_equal(0, @board.amount(63))
  end

  def test_any?
    assert_equal(true, @board.any?(1))
    assert_equal(true, @board.any?(2))
    assert_equal(false, @board.any?(63))
  end

  def test_field_single
    assert_equal(1,  DartBoard::Field.new(1).val())
    assert_equal(1,  DartBoard::Field.new(1, "s").val())
    assert_equal(1,  DartBoard::Field.new(1, "S").val())
    assert_equal(4,  DartBoard::Field.new(4).val())
  end

  def test_field_double
    assert_equal(2,  DartBoard::Field.new(1, "d").val())
    assert_equal(4,  DartBoard::Field.new(2, "D").val())
    assert_equal(50,  DartBoard::Field.new(25, "d").val())
  end

  def test_field_triple
    assert_equal(3,  DartBoard::Field.new(1, "t").val())
    assert_equal(6,  DartBoard::Field.new(2, "T").val())
    assert_equal(60,  DartBoard::Field.new(20, "t").val())
  end

end