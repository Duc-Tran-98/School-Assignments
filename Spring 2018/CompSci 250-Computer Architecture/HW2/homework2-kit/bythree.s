
.text
.align 2
.globl main

main:	
	li $v0, 5
	syscall
	move $t9, $v0
	addi $t9, $t9, 1
	li $t0, 1
	li $t1, 3
	
loop:
	mult $t0, $t1
	addi $t0, $t0, 1
	li $v0, 1
	mflo $a0
	syscall
	li $v0, 4
	la $a0, nln
	syscall
	bne $t0, $t9, loop
	
	li $v0, 10
	syscall
	
.end main

.data
nln:	.asciiz "\n"