
.text
.align 2
.globl main
	
	addi $sp, $sp, -4	#\
	sw $ra, 0($sp)		# Saving Home Address
	li $s7, 0			# Creates a count 
	la $s4, done
	j getName
	lw $ra, 0($sp)
	addi $sp, $sp, 4
	jr $ra
	
getName:
	la @a0, prpt		#\
	li $v0, 4			# Prints the Player Name Prompt
	syscall				#/
	li $v0, 8
	la $s5, name
	move $a0, $s5
	li $a1, 255
	syscall
	j checkDone
	
getScores:
	
 
 ret:
	jr $ra
 
checkDone:
	lb $s5, 0($a0)
	lb $s3, 0($s4)
	bne $s5, $s3, getScores
	beq $s5, $0, ret
	addi $a0, $a0, 1
	addi $s4, $s4, 1
	j checkDone
	
.end main
	
.data
	
	prpt1:	.asciiz "Player Name: "
	prpt2:	.asciiz "Total Points: "
	prpt3:	.asciiz "Total Assists: "
	prpt4:	.asciiz "Total Minutes: "
	done:	.asciiz "DONE"
	name:	.space 256