package com.example.apinovasi.utils

/**
 * Interface for invisible spans that aren't used for styling.
 */
interface Mark

/**
 * Marks the opening tag location of a list item inside an <ul> element.
 */
class BulletListItem : Mark

/**
 * Marks the opening tag location of a list item inside an <ol> element.
 */
class NumberListItem(val number: Int) : Mark