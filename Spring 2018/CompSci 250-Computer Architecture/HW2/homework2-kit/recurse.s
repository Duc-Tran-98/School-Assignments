
.text
.align 2
.globl main

main:
	
	li $v0, 4			#\
	la $a0, line		# \
	syscall				#  \
	li $v0, 5			#   Prompts the user to input an integer
	syscall				#	Sets up for the recursive call
	move $a0, $v0		#  /
	addi $s7, $0, 1		# /
	addi $s6, $0, 0		#/
	addi $s5, $0, 3
	jal func		# Jumps to recursive call
	move $a0, $v0
	li $v0, 1
	syscall
	li $v0, 10
	syscall
	
func:
	beq $a0, $s6, base0		#\
	beq $a0, $s7, base1		# Base Cases
	addi $sp, $sp, -12
	sw $ra, 8($sp)
	sw $a0, 0($sp)
	lw $s0, 0($sp)
	addi $a0, $s0, -2
	jal func
	sw $v0, 4($sp)
	lw $s0, 0($sp)
	addi $a0, $s0, -1
	jal func
	move $s1, $v0
	lw $s0, 4($sp)
	mult $s0, $s5
	mflo $s0
	add $v0, $s0, $s1
	addi $v0, $v0, 1
	lw $ra, 8($sp)
	addi $sp, $sp, 12
	jr $ra
	
base0:
	li $v0, 2
	jr $ra
	
base1:
	li $v0, 3
	jr $ra
	
.end main

.data

nln:	.asciiz "\n"
line:	.asciiz "Enter an integer greater than 0: "